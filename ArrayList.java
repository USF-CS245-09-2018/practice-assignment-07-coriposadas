/*
 * @author Cori Posdas
*/
public class ArrayList implements List{

	private Object [] arr;
	private int size;

	public ArrayList(){
		arr = new Object [10];
		size = 0;
	}

	public void growArray(){
		Object [] newArr = new Object [arr.length * 2];
		// Equivalent to conventional for loop below but array.copy is faster:
		// for (int i = 0; i < arr.length; i++){
		// 	newArr[i] = arr[i];
		// }
		System.arraycopy(arr, 0, newArr, 0, arr.length);

		arr = newArr;
	}

	public void add(Object obj){
		if (size == arr.length){
			growArray();
		}
		arr[size] = obj;
		++size;
	}

	public void add(int pos, Object obj){
		if (size == arr.length){
			growArray();
		}
		// Equivalent to conventional for loop below but array.copy is faster:
		// for (int i = size-1; i > pos; i--){
		// 	arr[i+1] = arr[i];
		// }
		System.arraycopy(arr, pos, arr, pos + 1, size - pos);	

		arr[pos] = obj;
		++size;
	}

	public Object get(int pos){
		return arr[pos];
	}

	public Object remove(int pos){
		Object temp = arr[pos];
		// Equivalent to conventional for loop below but array.copy is faster:
		// for (int i = pos; i < size; i++){
		// 	arr[i] = arr[i+1];
		// }
		--size;
		System.arraycopy(arr, pos + 1, arr, pos, size - pos);
		return temp;
	}

	public int size(){
		return size;
	}
}