import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private class Node implements Comparable<Node>{
		public int value;
		public int count;
		public int idx;

		public Node(int value, int count, int idx){
			this.value = value;
			this.count = count;
			this.idx = idx;
		}

		public Node(Node other){
			this.value = other.value;
			this.count = other.count;
			this.idx = other.idx;
		}

		@Override
		public int compareTo(Node other){
			return Integer.compare(this.value, other.value);
		}

	}


	public List<Integer> countSmaller(int[] nums) {
  		List<Node> lst = new ArrayList<>();
		
		for(int i=0; i<nums.length; i++){
			lst.add(new Node(nums[i], 0, i));
		}
		
		mergeSort(lst, 0, lst.size() - 1);
		
		List<Integer> sol = new ArrayList<>(Collections.nCopies(nums.length, 0));
		
		for(Node node: lst){
			sol.set(node.idx, node.count);
		}

		return sol;
    }

	private void mergeSort(List<Node> lst, int low, int high){
		if(low < high){
			int mid = low + (high-low)/2;
			mergeSort(lst, low, mid);
			mergeSort(lst, mid+1, high);

			merge(lst, low, mid, high);
		}
	}

	private void merge(List<Node> lst, int low, int mid, int high){
		int m = mid - low + 1;
		int n = high - mid;
		List<Node> A = new ArrayList<>();
		List<Node> B = new ArrayList<>();

		for(int i=0; i<m; i++){
			A.add(new Node(lst.get(low + i)));
		}
		
		for(int i=0; i<n; i++){
			B.add(new Node(lst.get(mid + 1 + i)));
		}
		
		// process
		int ptrA = 0;
		int ptrB = 0;
		while(ptrA < m){
			while(ptrB < n && B.get(ptrB).value < A.get(ptrA).value){
				ptrB++;
			}
			A.get(ptrA).count += ptrB;
			ptrA++;
		}

		// sort
		int i=0; 
		int j=0;
		int k=low;
		while(i<m && j<n){
            if (A.get(i).value <= B.get(j).value) {
                lst.set(k, new Node(A.get(i)));
                i++;
            } else {
                lst.set(k, new Node(B.get(j)));
                j++;
            }
			k++;
		}

		while(i < m){
			lst.set(k, new Node(A.get(i)));
			i++;
			k++;
		}

		while(j < n){
			lst.set(k, new Node(B.get(j)));
			j++;
			k++;
		}

	}


}