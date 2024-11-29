package Lab4Ex;

public class DynString {
    private char[] data;

    // Default constructor
    public DynString() {
        this.data = new char[0];
    }

    // Construct of given size
    public DynString(int len) {
        resizeData(len);
    }

    // Construct copying values from char array
    public DynString(char[] src) {
        this(src.length);
        for (int i = 0; i < size(); ++i) {
            data[i] = src[i];
        }
    }

    // Construct from String
    public DynString(String src) {
        this(src.toCharArray());
    }

    // Construct with fill character
    public DynString(int len, char fill) {
        this(len);
        for (int i = 0; i < len; ++i) {
            data[i] = fill;
        }
    }

    // Get current size
    public int size() {
        return data.length;
    }

    // Resize internal array; zeroes all values
    private void resizeData(int n) {
        data = new char[n];
    }

    // Check if empty
    public boolean empty() {
        return size() == 0;
    }

    // Get character at index
    public char get(int index) {
        return data[index];
    }

    // Set character at index
    public void set(int index, char value) {
        data[index] = value;
    }

    // Resize the array
    public void resize(int newSize) {
        char[] newData = new char[newSize];
        for (int i = 0; i < Math.min(size(), newSize); ++i) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // Clear the array
    public void clear() {
        resizeData(0);
    }

    // Check equality with a string
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() != size()) {
                return false;
            }
            for (int i = 0; i < size(); ++i) {
                if (data[i] != str.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // Substring from start index to end index
    public DynString substr(int start, int end) {
        char[] subData = new char[end - start];
        for (int i = start; i < end; ++i) {
            subData[i - start] = data[i];
        }
        return new DynString(subData);
    }

    // Substring from start index to end of string
    public DynString substr(int start) {
        return substr(start, size());
    }

    // Concatenate with another DynString
    public DynString concat(DynString other) {
        char[] newData = new char[size() + other.size()];
        for (int i = 0; i < size(); ++i) {
            newData[i] = data[i];
        }
        for (int i = 0; i < other.size(); ++i) {
            newData[size() + i] = other.data[i];
        }
        return new DynString(newData);
    }

    // Concatenate with a string
    public DynString concat(String str) {
        return concat(new DynString(str));
    }
}