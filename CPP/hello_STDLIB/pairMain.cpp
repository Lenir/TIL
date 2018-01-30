
#include "pairMain.h"

using namespace std;
void pair_main(){
	vector<pair<int, string> > intStrPairVector;
	pair<int, string> intStrPair;

	intStrPair.first = 1;
	intStrPair.second = "alpha";

	intStrPairVector.push_back(intStrPair);
	intStrPairVector.push_back(make_pair(2, "beta"));
	intStrPairVector.push_back(make_pair(3, "charile"));

	printPairVectorElements(&intStrPairVector);

}

void printPairVectorElements(vector<pair<int, string> > *pairVector){
	vector<pair<int, string> >::iterator pairVectorItr;
	for(pairVectorItr = (*pairVector).begin(); pairVectorItr != (*pairVector).end(); pairVectorItr++){
		cout<< "(" <<(*pairVectorItr).first<<", "<<(*pairVectorItr).second << ")" << endl;
	}
}
