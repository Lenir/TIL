/*
 * template_specialization.cpp
 *
 *  Created on: 2018. 2. 18.
 *      Author: Ciel
 */

#include "template_specialization.hpp"

template <typename T>
TemplateClassNotInteger<T>::TemplateClassNotInteger(const string& _name, const T& _data){
	name = _name;
	data = _data;
}

template <typename T>
string TemplateClassNotInteger<T>::getName() const{
	return name;
}

template <typename T>
T TemplateClassNotInteger<T>::getData() const{
	return data;
}

// int-template specialize
TemplateClassNotInteger<int>::TemplateClassNotInteger(const string& _name, const int& _data){
	name = _name;
	data = _data;
}

string TemplateClassNotInteger<int>::getName() const{
	return ":: INT TEMPLATE CLASS NAME " + name;
}


int TemplateClassNotInteger<int>::getData() const{
	return data;
}

int main_template(){
	TemplateClassNotInteger<string> strClass("strClassName", "awesome");
	TemplateClassNotInteger<double> doubleClass("doubleClassName", 3.14);
	// specialized int template class
	TemplateClassNotInteger<int> intClass("intClassName", 42);

	cout << strClass << doubleClass << intClass;
}
