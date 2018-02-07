#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void buildPartialVector(int, vector<int>&);

void buildArrayVector(int rows, vector< vector<int> >& arrayVector){
	for(int index = 0; index < rows; index++){
		int rowLen;
		cin >> rowLen;
		vector<int> varArray;
		buildPartialVector(rowLen, varArray);
		arrayVector.push_back(varArray);
	}
}

void buildPartialVector(int rowLen, vector<int>& varArray){
	for(int element = 0; element < rowLen; element++){
		int temp;
		cin >> temp;
		varArray.push_back(temp);
	}
}

void printAnswer(int queries, vector< vector<int> >& arrayVector){
	for(int query = 0; query < queries; query++){
	    		int row, col;
	    		cin >> row >> col;
	    		int answer = arrayVector[row][col];
	    		cout << answer << endl;
	}
}

int main___() {
    int rows, queries;

    cin >> rows >> queries;
    vector< vector<int> > arrayVector;

    buildArrayVector(rows, arrayVector);
    printAnswer(queries, arrayVector);

    return 0;
}
