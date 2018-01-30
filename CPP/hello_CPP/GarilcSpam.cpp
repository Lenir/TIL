/*
 * GarilcSpam.cpp
 *
 *  Created on: 2018. 1. 30.
 *      Author: Ciel
 */

#include "GarilcSpam.h"

GarilcSpam::GarilcSpam() {
	// TODO Auto-generated constructor stub
	spamSong = "garilc spam is more";
}

GarilcSpam::~GarilcSpam() {
	// TODO Auto-generated destructor stub
}

string GarilcSpam::getSong(){
	return spamSong + Spam::getSong();
}
