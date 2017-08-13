//Merge Sort.cpp
#include <iostream>
#include <random>

using namespace std;

void initialize(int A[], int n){

	//initialize the array
	for(int i=0; i<n; i++){
		A[i]=rand()%100000007;
	}

}

void my_merge(int A[], int aux[], int first, int mid, int last){
	int ix = first, jx = mid+1, cur_ind = first;
	//till elements are in both the halves
	while(ix <= mid && jx <= last){
		if(A[ix]<A[jx]){
			aux[cur_ind] = A[ix];
			ix++;
		}else{
			aux[cur_ind] = A[jx];
			jx++;
		}
		cur_ind++;
	}

	//if some elements remaining in first half
	while(cur_ind <= last && ix <= mid){
		aux[cur_ind] = A[ix];
		ix++;
		cur_ind++;
	}

	//if some elements remaining in second half
	while(cur_ind <= last && jx <= last){
		aux[cur_ind] = A[jx];
		jx++;
		cur_ind++;
	}

	//copy back
	for(ix = first ; ix <= last; ix++ ){
		A[ix] = aux[ix];
	}
}

//sort using merge_sort paradigm
void merge_sort(int A[], int aux[], int first, int last){

	if(first>=last){
		return;
	}
	int mid = first + (last-first)/2;
	merge_sort(A,aux, first, mid);
	merge_sort(A,aux, mid+1, last);

	my_merge(A, aux, first, mid, last);

}

void display(int A[], int n){
	for(int i =0; i<n; i++){
		cout<<A[i]<<" ";
	}
	cout<<endl;
}

int main(){

	int A[10], aux[10];

	initialize(A, 10);
	display(A, 10);
	merge_sort(A, aux, 0, 9);
	display(A, 10);

	return 0;
}
