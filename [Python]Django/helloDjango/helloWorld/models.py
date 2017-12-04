from django.db import models

# Create your models here.
class Guest(models.Model):
    name = models.CharField(max_length=10)
    introduction = models.TextField()
    area = models.CharField(max_length=15)
    age = models.IntegerField(default=19)
    isForeigner = models.BooleanField(default=False)
    def __str__(self):
        return self.name

class PajamaParty(models.Model):
    startDate = models.DateTimeField()
    endDate = models.DateTimeField()
    partyAddr = models.CharField(max_length= 50)

class MVPvote(models.Model):
    party = models.ForeignKey(PajamaParty)
    mvp = models.ForeignKey(Guest)
    votes = models.IntegerField(default=0)
