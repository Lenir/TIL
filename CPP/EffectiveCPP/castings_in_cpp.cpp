/*
 * castings_in_cpp.cpp
 *
 *  Created on: 2018. 2. 15.
 *      Author: Ciel
 */

#include "castings_in_cpp.hpp"

using namespace std;

class Parent{
public:
	Parent(const string& _name) : name(_name) {}

	virtual ~Parent() {}
	virtual void printName(){
		cout << ":: Parent - " << name << " ";
	}

private:
	string name;
};

class Child : public Parent{
public:
	Child(const string& _name, const string& _childName) : Parent(_name), childName(_childName) {}
	virtual ~Child() {}

	virtual void printName(){
		Parent::printName();
		cout << ":: Child - " << childName << " ";
	}
private:
	string childName;
};

int main(){

	/* castings in cpp.
	 * const_cast : remove const cast
	 * static_cast : c-style cast
	 * dynamic_cast : class pointer cast. run-time type check.
	 * 				 return NULL when downcast
	 */

	const char* sampleString = "sampleString";

	char* obviouslyCanCast = (char*)sampleString;
	string castedString = (string)sampleString;
	int* somethingsWrong = (int*)sampleString;

	cout << "< c-style castings - with bug case >" << endl;
	cout << obviouslyCanCast << endl;
	cout << castedString << endl;
	cout << *somethingsWrong << endl;

	// const_cast : remove const
	char* constCastedChar = const_cast<char*>(sampleString);

	// static_cast : similar with c-style castings
	const char* staticCastedChar = static_cast<const char*>(sampleString);

	cout << "< const, static castings - no errors >" << endl;
	cout << constCastedChar << endl;
	cout << staticCastedChar << endl;

	// dynamic cast : class pointer cast - return NULL when down-casting
	// down-casting : (parent class pointer -> derived class pointer. lack of data)
	Child child("trump", "trump jr.");
	Parent parent("trump sr.");
	Parent* parent1 = dynamic_cast<Parent*>(&child);
	Child* downCasted = dynamic_cast<Child*>(&parent); // is NULL

	Parent* fakeParent = dynamic_cast<Parent*>(&child);
	// fake downcast.
	// downcast, but actual instance is child. so it's not downcasting.
	Child* fakeDowncast = dynamic_cast<Child*>(fakeParent);

	cout << "< dynamic castings : with error case - downcasting >" << endl;
	parent1->printName();
	cout << endl;

	cout << "downCasted : ";
	if(downCasted){
		downCasted->printName();
		cout << endl;
	}else{
		cout << "failed..." << endl;
	}

	cout << "downCasted_fake : ";
	if(fakeDowncast){
		fakeDowncast->printName();
		cout << endl;
	}else{
		cout << "failed..." << endl;
	}

}
