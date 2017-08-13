#include <iostream>
#include <random>
#include <cmath>
using namespace std;

//returns index if found else -1
int linear_search(vector<int>&vec, int num){
	for(int i =0; i <vec.size(); i++){
		if(vec[i]==num){
			return i;
		}
	}
	return -1;
}

//function to push num_elements integers in vector
void push_elements_in_vec(vector<int>&vec , int num_elements){

	for(int i = 0; i< num_elements; i++){
		vec.push_back(int(rand()));
	}

}

void print_vec(vector<int>&vec){
    for(int i = 0; i<vec.size(); i++){
        cout<<vec[i]<<" ";
    }
    cout<<endl;
}

int main(){

	vector<int> vec;

	//insert some random elements in vector
	push_elements_in_vec(vec, 10);
    print_vec(vec);
	int ind = linear_search(vec, 10);
	if(ind ==-1){
		cout<<"Element not found"<<endl;
	}else{
		cout<<"Element found at index "<<ind<<endl;
	}
	ind = linear_search(vec, vec[9]);
	if(ind ==-1){
		cout<<"Element not found"<<endl;
	}else{
		cout<<"Element found at index "<<ind<<endl;
	}

	return 0;
}
