/*
 * Use_const_for_safety_programming.cpp
 *
 *  Created on: 2018. 2. 14.
 *      Author: Ciel
 */

#include "Use_const_for_safety_programming.hpp"

using namespace std;

template<typename T>
class SomeClass{
public:
	SomeClass(const string& _bornName, const T& _data) :
		bornName(_bornName), data(_data), curName(_bornName) {}
	// reference var can change via method!
	// so reference parameter must throw with const.

	string getBornName() const{
		// const method doesn't change member variable.
		return bornName;
	}

	void setBornName(const string& _bornName) const{
//		bornName = _bornName;
//		compile error (cannot change member)
		cout << "cannot change member born name '" << bornName << "' to '" << _bornName << "'" << endl;
	}

	void setCurName(const string& _curName) const{
//		const method can change mutable member.
//		It's like exception, so do not use frequently.
		curName = _curName;
	}

	void setData(const T& _data){
//		non_const method can change member!
		data = _data;
	}

	void print() const{
		cout << curName << ", " << data << endl;
	}


private:
	string bornName;
	T data;
	mutable string curName;
};

int main_const(){
	SomeClass<int> someIntClass("awesomeName", 42);
	someIntClass.print();
	someIntClass.setBornName("notAwesomeName");
	someIntClass.print();
	someIntClass.setCurName("notAwesomeName");
	someIntClass.print();

}


