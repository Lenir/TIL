/*
 * Wrapper_class_for_prevent_wrong_use.cpp
 *
 *  Created on: 2018. 2. 19.
 *      Author: Ciel
 */

# include "Wrapper_class_for_prevent_wrong_use.hpp"

int main_wrapperClass(){
	cout << "< When there's no mistakes >" << endl;

	string abrahamAddr = "L.Memorial NW, Washington DC, USA";
	string theodoreAddr = "Central Park West & 79th St. New York, USA";
	Student_withoutWrapper valid_withoutWrapper("Abraham", abrahamAddr);
	Student_withWrapper valid_withWrapper(StudentName("Theodore"), StudentAddress(theodoreAddr));

	cout << valid_withoutWrapper << valid_withWrapper;


	cout << endl << "< When there's MISTAKES >" << endl;

	Student_withoutWrapper invalid_withoutWrapper(abrahamAddr, "Abraham");
	// wrong initialize on wrapper class causes compiler error!
//	Student_withWrapper invalid_withWrapper(StudentAddress(theodoreAddr), StudentName("Theodore"));
	cout << invalid_withoutWrapper << ":: COMPILE ERROR" << endl;

}

