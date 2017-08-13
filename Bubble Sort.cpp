//Bubble Sort.cpp
#include <iostream>
#include <random>

using namespace std;

void initialize(int A[], int n){

	//initialize the array
	for(int i=0; i<n; i++){
		A[i]=rand()%100000007;
	}

}
//sort using bubble_sort paradigm
void bubble_sort(int A[], int first, int last){
	int aux_val;
	for(int i = last; i > 0 ; i--){
		for(int j=0; j < i ; j++){
			aux_val = min(A[j], A[j+1]);
			A[j+1] = max(A[j], A[j+1]);
			A[j] = aux_val;
		}
	}
	return;
}

void display(int A[], int n){
	for(int i =0; i<n; i++){
		cout<<A[i]<<" ";
	}
	cout<<endl;
}

int main(){

	int A[10];

	initialize(A, 10);
	display(A, 10);
	bubble_sort(A, 0, 9);
	display(A, 10);

	return 0;
}
