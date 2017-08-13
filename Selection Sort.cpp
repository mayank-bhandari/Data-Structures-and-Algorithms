//Selection Sort

#include <iostream>

using namespace std;

void initialize(int A[], int n){

	//initialize the array
	for(int i=0; i<n; i++){
		A[i]=rand()%100000007;
	}

}
//sort using selection_sort paradigm
void selection_sort(int A[], int first, int last){
	for(int i = first ; i <last ; i++){
		int min_val = A[i], ind = i;
		for(int j = i+1; j <= last; j++){
            //select the minimum and remember it's index
			if(A[j]<min_val){
				min_val = A[j];
				ind = j;
			}
		}
		int aux_val = A[i];
		A[i] = min_val;
		A[ind] = aux_val;
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
	selection_sort(A, 0, 9);
	display(A, 10);

	return 0;
}
