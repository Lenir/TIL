/*
 * hackerrank_maps.cpp
 *
 *  Created on: 2018. 2. 7.
 *      Author: Ciel
 */

#include <iostream>
#include <vector>
#include <map>

using namespace std;

void markStudent(string &name, int &mark, map<string, int> &students){
	map<string, int>::iterator mapIter;
	mapIter = students.find(name);
	if(mapIter == students.end()){
		students.insert(make_pair(name, mark));
	}else{
		mapIter->second = mapIter->second + mark;
	}
}

void clearMark(string name, map<string, int> &students){
	map<string, int>::iterator mapIter;
	mapIter = students.find(name);
	if(mapIter == students.end()){
	}else{
		mapIter->second = 0;
	}
}

void printStudent(string name, map<string, int> &students){
	map<string, int>::iterator mapIter;
	mapIter = students.find(name);
	if(mapIter == students.end()){
		cout<<0<<endl;
	}else{
		cout<<mapIter->second<<endl;
	}
}

int main(){
	int queries, operation, mark;
	string name;
	cin >> queries;
	map<string, int> students;
	for(int i = 0; i < queries; i++){

		cin >> operation >> name;
		if(operation == 1){
			cin >> mark;
			markStudent(name, mark, students);
		}else if(operation == 2){
			clearMark(name, students);
		}else{
			printStudent(name, students);
		}
	}
}



