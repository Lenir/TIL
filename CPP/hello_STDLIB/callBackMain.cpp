//
//  callBackMain.cpp
//  helloCPPXcode2
//
//  Created by Ciel on 2018. 1. 31..
//  Copyright © 2018년 Lenir. All rights reserved.
//

#include "callBackMain.hpp"

void printElement(string element){
    cout<< "element : " << element << endl;
}

void callback_main(){
    vector<string> strVector;
    
    strVector.push_back("alpha");
    strVector.push_back("beta");
    strVector.push_back("charlie");
    strVector.push_back("delta");
    
    for_each(strVector.begin(), strVector.end(), printElement);
    
}
