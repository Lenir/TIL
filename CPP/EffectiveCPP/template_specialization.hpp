/*
 * template_specialization.hpp
 *
 *  Created on: 2018. 2. 18.
 *      Author: Ciel
 */

#ifndef TEMPLATE_SPECIALIZATION_HPP_
#define TEMPLATE_SPECIALIZATION_HPP_

#include <iostream>

using namespace std;

template <typename T>
class TemplateClassNotInteger{
public:
	TemplateClassNotInteger(const string& name, const T& data);
	string getName() const;
	T getData() const;
	friend ostream& operator <<(ostream& out, const TemplateClassNotInteger<T>& input){
		out << input.getName() << " : " << input.getData() << endl;
		return out;
	}

private:
	string name;
	T data;
};

template <>
class TemplateClassNotInteger<int>{
public:
	TemplateClassNotInteger(const string& name, const int& data);
	string getName() const;
	int getData() const;
	friend ostream& operator <<(ostream& out, const TemplateClassNotInteger<int>& input){
		out << input.getName() << " : " << input.getData() << endl;
		return out;
	}

private:
	string name;
	int data;
};


#endif /* TEMPLATE_SPECIALIZATION_HPP_ */
