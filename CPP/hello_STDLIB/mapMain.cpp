/*
 * mapMain.cpp
 *
 *  Created on: 2018. 1. 30.
 *      Author: Lenir
 */

#include "mapMain.h"

using namespace std;

void map_main(){
	unordered_map<int, string> intStrMap;
	intStrMap.insert(make_pair(1, "alpha"));
	intStrMap.insert(make_pair(2, "beta"));
	intStrMap.insert(make_pair(3, "charlie"));

	printMapElements(&intStrMap);
}

void printMapElements(unordered_map<int, string> *intStrMap){
	unordered_map<int, string>::iterator intStrMapItr;
	for(intStrMapItr = (*intStrMap).begin(); intStrMapItr != (*intStrMap).end(); intStrMapItr++){
		cout<< "(" << (*intStrMapItr).first << ", "<< (*intStrMapItr).second << ")" << endl;
	}
}
