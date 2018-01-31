#include <iostream>

#include "listMain.h"
#include "vectorMain.h"
#include "setMain.h"
#include "pairMain.h"
#include "mapMain.h"
#include "callBackMain.hpp"



using namespace std;
int main(){
	cout<<" <vector> "<<endl;
	vector_main();

	cout<<" <list> "<<endl;
	list_main();

	cout<<" <set> "<<endl;
	set_main();

	cout<<" <pair> "<<endl;
	pair_main();

	cout<<" <map> "<<endl;
	map_main();
    
    	cout<<" <callback - for_each> "<<endl;
    	callback_main();
}
