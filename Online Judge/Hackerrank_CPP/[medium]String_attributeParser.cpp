/*
 * hackerrank_attributeParser.cpp
 *
 *  Created on: 2018. 2. 8.
 *      Author: Ciel
 */
#include <cstdio>
#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

class Tag{
public:
	Tag(){
		name = "";
		parent = NULL;
	}
	Tag(string _name){
		name = _name;
		parent = NULL;
	}

	string getName(){
		return name;
	}

	void insertSubtag(string _name, Tag* tag){
		subtags.insert(make_pair(_name, tag));
	}

	Tag* getParent(){
		if(parent != NULL){
			return parent;
		}else{
			throw "no parent exception";
		}
	}

	void setParent(Tag& _parent){
		parent = &_parent;
	}

	string getAttribute(string attribute){
		map<string, string>::iterator it = attributes.find(attribute);
		if(it == attributes.end()){
			throw "Attribute not found";
		}else{
			return it->second;
		}
	}

	Tag* getSubtag(string _name){
		map<string, Tag*>::iterator it = subtags.find(_name);
		if(it == subtags.end()){
			throw "Tag not found";
		}else{
			return it->second;
		}
	}

	void insertAttribute(string attrName, string attrValue){
		attributes.insert(make_pair(attrName, attrValue));
	}

	void setName(string name){
		this->name = name;
	}
	map<string, Tag*> subtags;
private:
	string name;
	Tag* parent;

	map<string, string> attributes;
};


void handleTags(Tag* upperTag, string tagLine, int leftTags){
	if(leftTags == 1) return;
	string withoutBracket = tagLine.erase('<');
	withoutBracket = tagLine.erase('>');

//	string withoutBracket = tagLine.substr(tagLine.find('<')+1, tagLine.find('>')-1);
	stringstream tagStream(withoutBracket);
	string temp, name, attrName, attrVal;
	tagStream >> temp;
	if(temp[0] == '/'){
		// enclosing tag do nothing.
		if(leftTags > 0){
			string newTagLine;
			cin.ignore();
			getline(cin, newTagLine);
			handleTags((upperTag->getParent()), newTagLine, leftTags-1);
		}
	}else{
		// opens tag
		Tag* newTag = new Tag();
		name = temp;
		newTag->setName(name);
		newTag->setParent(*upperTag);
		while(!tagStream.eof()){
			char eq;
			// attr handle
			tagStream >> attrName >> eq >> attrVal;
			attrVal = attrVal.substr(1, attrVal.length()-2);
			newTag->insertAttribute(attrName, attrVal);
		}
		upperTag->insertSubtag(name, newTag);
		if(leftTags > 0){
			string newTagLine;
			getline(cin, newTagLine);
			handleTags(newTag, newTagLine, leftTags-1);
		}
	}
}

void handleQueries(string queryLine, Tag* upperTag){
	char c;
	string subString = "";
	Tag* tagPointer = upperTag;
	for(int i = 0; i<queryLine.length(); i++){
		c = queryLine[i];
		if(c == '.'){
			// search subTag
			try{
				tagPointer = ((*tagPointer).getSubtag(subString));
				subString = "";
			}catch (const char* e) {
			}

		}else if(c == '~'){
			// return attribute value
			try{
				tagPointer = ((*tagPointer).getSubtag(subString));
				subString = "";
			}catch (const char* e) {
			}
			string attrName = queryLine.substr(i+1, queryLine.length()-1);
			string attrVal;
			try {
				attrVal = (*tagPointer).getAttribute(attrName);
				cout << attrVal << endl;
			} catch (const char* e) {
				cout << "Not Found!" << endl;
			}
		}else{
			subString += c;
		}
	}
}

int main_parser(){
	int tagNum, queryNum;
	string tagLine, queryLine;

	cin >> tagNum >> queryNum;
	Tag body("body");

	cin.ignore();
	getline(cin, tagLine);
	handleTags(&body, tagLine, tagNum);


	for(int i = 0; i < queryNum; i++){
		getline(cin, queryLine);
		handleQueries(queryLine, &body);
	}

}

