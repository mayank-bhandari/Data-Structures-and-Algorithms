//Heap Sort
#include <iostream>

using namespace std;

//display the array
void display(int A[], int my_size){
	for(int i = 1 ; i <=my_size; i++){
		cout<<A[i]<<" ";
	}
	cout<<endl;
}

// max_heapify the heap
// my_size - size of the heap remaining
void max_heapify(int A[], int ind, int my_size){

	// if leaf node, no need to go down further
	if(my_size < ind*2){
		return;
	}

	//assume left child is greater
	int aux_ind = ind*2, aux_val = A[ind*2];

	//if right child exists and is greater, then update
	if(ind*2+1 <= my_size && A[ind*2] < A[ind*2+1]){
		aux_ind += 1;
		aux_val = A[aux_ind];
	}

	//if child is larger than parent then switch and max hepaify the sub-tree/sub-heap
	if(A[aux_ind] > A[ind]){
		A[aux_ind] = A[ind];
		A[ind] = aux_val;
		max_heapify(A, aux_ind, my_size);
	}
	return;
}

void create_heap(int A[], int my_size){
	for(int ix = my_size/2; ix>0; ix--){
		max_heapify(A, ix, my_size);
	}
}

void heap_sort(int A[], int my_size){


	//make max-heap
	create_heap(A, my_size);
	cout<<"After making heap : ";
	display(A, my_size);

	//sort
	for(int i = my_size, aux = 0; i > 1 ; i--){
		aux = A[i];
		A[i] = A[1];
		A[1] = aux;
		max_heapify(A, 1, i-1);
	}

	cout<<"After Heap sort : ";
	display(A, my_size);
}

//initialize array with random values
void initialize_array(int A[], int my_size){
	for(int i = 1; i <= my_size; i++)
		A[i] = rand()%100000007;
}

int main(){
	int A[31] = {0};
	int my_size = 10;

	initialize_array(A, 30);

	cout<<"Initial array : ";
	display(A, my_size);

	heap_sort(A, my_size);

	return 0;
}
