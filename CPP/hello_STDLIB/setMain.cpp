
#include "setMain.h"

using namespace std;
void set_main(){
	set<string> strSet;

	strSet.insert("alpha");
	strSet.insert("beta");
	strSet.insert("charlie");
	strSet.insert("delta");

	strSet.erase("delta");

	printSetElements(&strSet);

	set<string>::iterator deltaItr = strSet.find("delta");
		if(deltaItr == strSet.end()){
			cout<< "there is no delta in here" << endl;
		}else{
			cout<< "delta is in this set" << endl;
		}
}

void printSetElements(set<string> *strSet){
	set<string>::iterator strSetItr;
	for(strSetItr = (*strSet).begin(); strSetItr != (*strSet).end(); strSetItr++){
		cout<< (*strSetItr) << endl;
	}
}
