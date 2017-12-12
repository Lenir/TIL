from bs4 import BeautifulSoup
import requests
import re

# from urllib import request
html_source = requests.get("http://blog.naver.com/1net1/221156999402").text
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

postArea = postSoup.find('div', {'class':'se_component_wrap sect_dsc __se_component_area'})
# print(postArea)
paragraphs = postSoup.find_all('div',{'class':'se_editArea'})
# print(paragraphs)
result = []
for paragraph in paragraphs:
    # if str(paragraph).__contains__("se_textarea"):
    #     search = re.search('<!-- SE3-TEXT { -->.*?<!-- } SE3-TEXT --></p>', str(paragraph), re.I|re.S|re.DOTALL)
    #     if search == None:
    #         pass
    #     else:
    #         text = str(search.group())
    #         text = re.sub('<!-- SE3-TEXT { -->', '', text, 0, re.I|re.S)
    #         text = re.sub('<!-- } SE3-TEXT --></p>', '', text, 0, re.I|re.S)
    #         result.append(text)
    # elif str(paragraph).__contains__("se_viewArea"):
    #     result.append(paragraph)
    result.append(paragraph)

for element in result:
    print(element)


    #
# textParagraphs = postSoup.find_all('div', {'class':'se_component se_paragraph default'})
#
# textTags = []
# texts = []
# for paragraph in textParagraphs:
#     text = str(re.search('<p class="se_textarea"><!-- SE3-TEXT { -->.*?<!-- } SE3-TEXT --></p>', str(paragraph), re.I|re.S|re.DOTALL).group())
#     text = re.sub('<p class="se_textarea"><!-- SE3-TEXT { -->', '', text, 0, re.I|re.S)
#     text = re.sub('<!-- } SE3-TEXT --></p>', '', text, 0, re.I|re.S)
#
#     print(text)
#


# print(texts)