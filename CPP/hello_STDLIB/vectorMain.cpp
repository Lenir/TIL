
#include <iostream>
#include <vector>
#include <iterator>

#include "vectorMain.h"

using namespace std;

void printVectorElements(vector<string>*);

void vector_main(){
	vector<string> strVector(5);
	strVector[0] = "alpha";
	strVector[1] = "beta";
	strVector[2] = "charlie";

	strVector.push_back("delta");
	strVector.push_back("echo");
	strVector.pop_back();

	printVectorElements(&strVector);
}

void printVectorElements(vector<string>* strVector){
	vector<string>::iterator strVectorItr;

	for(strVectorItr = (*strVector).begin(); strVectorItr != (*strVector).end(); strVectorItr++){
		cout<< *strVectorItr << endl;
	}
}
