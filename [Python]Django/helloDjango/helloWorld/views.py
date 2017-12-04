from django.shortcuts import render
from django.http import HttpResponse, HttpResponseRedirect
from .models import *
from django.db.models import Sum
import datetime

# Create your views here.
def index(request):
    guests = Guest.objects.all()
    context = {'guests' : guests}
    return render(request, 'helloWorld/index.html', context)

def areas(request, area):
    today = datetime.datetime.now()
    try :
        party = PajamaParty.objects.get(partyAddr = area, startDate__lte = today, endDate__gte=today) # get에 인자로 조건을 전달해줍니다.
        guests = Guest.objects.filter(area = area) # Candidate의 area와 매개변수 area가 같은 객체만 불러오기
    except:
        party = None
        guests = None
    context = {'guests': guests,
    'area' : area,
    'party' : party }
    return render(request, 'helloWorld/area.html', context)

def pajamaparties(request, party_id):
    party = PajamaParty.objects.get(pk = party_id)
    selection = request.POST['MVPVote']

    try:
        mvpVote = MVPvote.objects.get(party_id = party.id, mvp_id = selection)
        mvpVote.votes += 1
        mvpVote.save()
    except:
        #최초로 투표하는 경우, DB에 저장된 Choice객체가 없기 때문에 Choice를 새로 생성합니다
        choice = MVPvote(party_id = party.id, mvp_id = selection, votes = 1)
        choice.save()

    return HttpResponseRedirect("/areas/{}/results".format(party.partyAddr))

def results(request, area):
    guests = Guest.objects.filter(area = area)
    parties = PajamaParty.objects.filter(partyAddr = area)
    poll_results = []
    for party in parties:
        result = {}
        result['startDate'] = party.startDate
        result['endDate'] = party.endDate

        total_votes = MVPvote.objects.filter(party_id=party.id).aggregate(Sum('votes'))
        result['total_votes'] = total_votes['votes__sum']

        rates = []  # 지지율
        vote = []
        for guest in guests:
            # choice가 하나도 없는 경우 - 예외처리로 0을 append
            try:
                choice = MVPvote.objects.get(party_id=party.id, mvp_id=guest.id)
                rates.append(
                    round(choice.votes * 100 / result['total_votes'], 1)
                )
                vote.append(choice.votes)
            except:
                rates.append(0)
        result['rates'] = rates
        result['vote'] = vote

        poll_results.append(result)

    context = {'guests':guests, 'area':area,
    'poll_results' : poll_results}
    return render(request, 'helloWorld/result.html', context)