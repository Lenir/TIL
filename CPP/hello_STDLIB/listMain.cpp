
#include <list>
#include <iostream>
#include "listMain.h"

using namespace std;

void list_main(){
	list<string> strList;
	strList.push_back("charile");
	strList.push_front("beta");
	strList.push_front("alpha");

	printListElements(&strList);

}

void printListElements(list<string> *strList){
	list<string>::iterator strListItr;
	for(strListItr = (*strList).begin(); strListItr != (*strList).end(); strListItr++){
		cout<< *strListItr << endl;
	}
}

