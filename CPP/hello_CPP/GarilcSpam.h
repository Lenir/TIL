/*
 * GarilcSpam.h
 *
 *  Created on: 2018. 1. 30.
 *      Author: Ciel
 */

#ifndef GARILCSPAM_H_
#define GARILCSPAM_H_

#include "Spam.h"

class GarilcSpam: public Spam {
private:
	string spamSong;
public:
	GarilcSpam();
	virtual ~GarilcSpam();

	string getSong();
};

#endif /* GARILCSPAM_H_ */
