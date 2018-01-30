/*
 * Spam.h
 *
 *  Created on: 2018. 1. 30.
 *      Author: Ciel
 */
#ifndef SPAM_H_
#define SPAM_H_
#include <string>

using namespace std;
class Spam {
private:
	string spamSong;
public:
	Spam();
	virtual ~Spam();

	string getSong();
};

#endif /* SPAM_H_ */
