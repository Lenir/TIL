#include <iostream>
#include <string>

#include "Spam.h"
#include "GarilcSpam.h"

using namespace std;
int main(){
	Spam spam = Spam();
	GarilcSpam gspam = GarilcSpam();
	cout<<spam.getSong()<<endl;
	cout<<gspam.getSong()<<endl;
}
