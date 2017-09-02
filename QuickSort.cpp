#include <iostream>
#include <random>

using namespace std;

void display(int A[], int start, int en);

//initialize the array with some random integers
void initialize(int A[], int n){
	for(int i=0; i<n; i++){
		A[i]=rand()%100000007;
	}
}


// create a partition with elements on the left of the pivot smaller than pivot element and
// elements larger than pivot elements on the right
int my_partition(int A[], int first, int last){

    cout<<"Array initially : ";
	display(A, first, last);

	// select a random pivot
	int pivot = first + rand()%(last-first);
    cout<<"Range : "<<first<<" "<<last<<endl;
    cout<<"Pivot : "<<pivot<<" element = "<<A[pivot]<<endl;

	int beg = first, en = last, temp = 0;

	//elements smaller should be put on the left
	while(A[beg]< A[pivot]){
		beg++;
	}
	//elements greater should be put on right,
	while(A[en]>A[pivot]){
		en--;
	}

    cout<<"Begin : "<<beg<<" end "<<en<<endl;
	//change the first larger element with the pivot element
	temp = A[beg];
	A[beg] = A[pivot];
	A[pivot] = temp;
	pivot = beg;

	//pivot has moved to the position beg
	//sort till end has moved to the pivot position
	while(en>pivot){
		// if element at en position is smaller than pivot element
		if(A[en] < A[pivot]){
			//swap A[pivot], A[pivot+1], A[en], pivot goes one place ahead
			temp = A[pivot];
			A[pivot] = A[en];
			A[en] = A[pivot+1];
			A[pivot+1] = temp;
			pivot += 1;
			//V. IMP : don't change en here
		}else{//change en here only
            en-=1;
		}
	}
	cout<<"Pivot element: "<<A[pivot]<<endl;
	cout<<"Elements on the left : ";
	display(A, first, pivot-1);
	cout<<endl<<"Elements on the right : "<<endl;
	display(A, pivot+1, last);
	cout<<endl;
	return pivot;

}


//sort using quick_sort paradigm
void quick_sort(int A[], int first, int last){
	//if only one element
	if(first>=last)return;

	//get the pivot element position, after partition the pivot element is always at its correct position
	int pivot = my_partition(A, first, last);


    //recursively sort the left and right partition
	quick_sort(A, first, pivot);
	quick_sort(A, pivot + 1, last);

	return;

}

// to display the contents of the array
void display(int A[], int start, int en){
	for(int i =start; i<=en; i++){
		cout<<A[i]<<" ";
	}
	cout<<endl;
}

//execution starts here
int main(){

    int si = 20;
	int A[si];
	initialize(A, si);



	//quick_sort(A, start, end) sort from index [start, end]
	quick_sort(A, 0, si-1);
	cout<<"Array after sorting : ";
	display(A, 0, si-1);

	return 0;
}
