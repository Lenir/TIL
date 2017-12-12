from bs4 import BeautifulSoup
import requests
# from urllib import request
html_source = requests.get("https://blog.naver.com/1net1/221159842052").text
soup = BeautifulSoup(html_source, "html5lib")
# elements = soup.find_all('div', {'class':'se_component se_paragraph default'})
mainFrameTag = soup.find('frame', {'id':'mainFrame'})
tags = str(mainFrameTag).split(' ')
postUrl = ""
for tag in tags:
    if tag.startswith("src="):
        postUrl = str(tag)[5:len(postUrl)-3]


postUrl = postUrl.replace("amp;","")
blogPostUrl = "https://blog.naver.com"+postUrl
print("getting : "+blogPostUrl)
blogPostHtml_source = requests.get(blogPostUrl).text
postSoup = BeautifulSoup(blogPostHtml_source, "html5lib")

textParagraphs = postSoup.find_all('div', {'class':'se_component se_paragraph default'})

textTags = []
texts = []
for paragraph in textParagraphs:
    textTags.append(paragraph.find('p', {'class':'se_textarea'}))

print(textTags)