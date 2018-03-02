/*
 * smart_pointer.cpp
 *
 *  Created on: 2018. 2. 16.
 *      Author: Ciel
 */

#include "use_smart_pointer_to_prevent_memoryLeak.hpp"

using namespace std;

int main_smartPtr(){
	// dynamic allocated - leakingPtr will not freed!
	// dynamic allocated, but using smart pointer - smartPtr will be freed
	MemoryLeak<int>* leakingPtr = causeMemoryLeak("leakingPtr", 42);
	auto_ptr<MemoryLeak<int> > smartPtr(causeMemoryLeak("smartPtr", 42));
}
