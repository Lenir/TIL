from bs4 import BeautifulSoup
import requests
import re

class NaverBlogCrawler:
    def __init__(self, url):
        pass

    def getPostBodyUrl(self, url):
        postHtmlSource = requests.get("http://blog.naver.com/1net1/221156999402").text
        soup = BeautifulSoup(html_source, "html5lib")

        mainFrameTag = soup.find('frame', {'id': 'mainFrame'})
        tags = str(mainFrameTag).split(' ')

        postUrl = ""
        for attribute in tags:
            if attribute.startswith("src="):
                postUrl = str(attribute)[5:len(attribute) - 3]

        postUrl = postUrl.replace("amp;", "")
        targetUrl = "https://blog.naver.com" + postUrl

        return blogPostUrl
