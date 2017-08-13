#include <iostream>
#include <random>

using namespace std;

void initialize(int A[], int n){

	//initialize the array
	for(int i=0; i<n; i++){
		A[i]=rand()%100000007;
	}

}
//sort using insertion_sort paradigm
void insertion_sort(int A[], int first, int last){
	int j = 0;
	for(int i = 1; i <= last; i++){
		int val = A[i] ;
		for(j = i-1; j >=0; j--){
			if(A[j]>val){
				A[j+1] = A[j];
			}else{
				break;
			}
		}
		A[j+1] = val;
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
	insertion_sort(A, 0, 9);
	display(A, 10);

	return 0;
}
