/*
 * smart_pointer.hpp
 *
 *  Created on: 2018. 2. 16.
 *      Author: Ciel
 */

#ifndef SMART_POINTER_HPP_
#define SMART_POINTER_HPP_

#include <iostream>

using namespace std;

template<typename T>
class MemoryLeak{
public:
	MemoryLeak(const string& _name, const T& _data){
		name = _name;
		data = _data;
		cout << ":: " << name << " class created! " << endl;
	}

	virtual ~MemoryLeak(){
		cout << ":: " << name << " class' memory free!" << endl;
	}
private:
	string name;
	T data;
};

template<typename T>
MemoryLeak<T>* causeMemoryLeak(const string& name, const T& data){
	MemoryLeak<T>* leakingPtr = new MemoryLeak<T>(name, data);
	return leakingPtr;
}

#endif /* SMART_POINTER_HPP_ */
