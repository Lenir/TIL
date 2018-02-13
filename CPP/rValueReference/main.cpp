/*
 * main.cpp
 *
 *  Created on: 2018. 2. 13.
 *      Author: Ciel
 */

#include <iostream>
#include <vector>

using namespace std;

class TempClass{
public:
	TempClass(){
		name = "";
		cout << ":: " << name << " generator called" << endl;
	}
	TempClass(string _name){
		name = _name;
		cout << ":: " << name << " generator called" << endl;
	}

	~TempClass(){
		cout << ":: " << name << " class destructor called" << endl;
	}

	void printRvalName(TempClass&& tempClass){
		cout << tempClass.name << endl;
	}
private:
	string name;
};


int main(){
	TempClass var("var");
	TempClass var2("var2");

	cout << "var addr : " << &var << " and var2 addr : " << &var2 << endl;

	TempClass& lValueRef = var2;
	cout << "hello" << endl;
	vector<int> intVector;
}


