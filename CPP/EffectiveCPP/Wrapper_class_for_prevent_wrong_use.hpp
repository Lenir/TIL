/*
 * Wrapper_class_for_prevent_wrong_use.hpp
 *
 *  Created on: 2018. 2. 19.
 *      Author: Ciel
 */

#ifndef WRAPPER_CLASS_FOR_PREVENT_WRONG_USE_HPP_
#define WRAPPER_CLASS_FOR_PREVENT_WRONG_USE_HPP_

#include <iostream>

using namespace std;

class Student_withoutWrapper{
public:
	Student_withoutWrapper(const string& _name, const string& _address) :
		name(_name), address(_address) {}

	friend ostream& operator<<(ostream& os, const Student_withoutWrapper& input){
		os << ":: '" << input.name << "' is live in " << input.address << endl;
		return os;
	}

private:
	string name;
	string address;
};

struct StudentName{
	StudentName(const string& _name) :
		name(_name) {}
	string name;

	friend ostream& operator<<(ostream& os, const StudentName& input){
		os << input.name;
		return os;
	}
};

struct StudentAddress{
	StudentAddress(const string& _address) :
		address(_address) {}
	string address;

	friend ostream& operator<<(ostream& os, const StudentAddress& input){
		os << input.address;
		return os;
	}
};

class Student_withWrapper{
public:
	Student_withWrapper(const StudentName& _name, const StudentAddress& _address) :
		name(_name), address(_address) {}

	friend ostream& operator<<(ostream& os, const Student_withWrapper& input){
		os << ":: '" << input.name << "' is live in " << input.address << endl;
		return os;
	}
private:
	StudentName name;
	StudentAddress address;
};


#endif /* WRAPPER_CLASS_FOR_PREVENT_WRONG_USE_HPP_ */
