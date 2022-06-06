package LC_2296;

class TextEditor {

    private int pivot;
    private StringBuilder sb;
    public TextEditor() {
        this.sb = new StringBuilder();
        this.pivot = 0;
    }

    public void addText(String text) {
        sb.insert(pivot, text);
        pivot += text.length();
    }

    public int deleteText(int k) {
        int temp = pivot;
        if (temp - k > 0) {
            sb.delete(temp - k, pivot);
            pivot -= k;
            return k;
        }
        pivot = 0;
        sb.delete(0, temp);
        return temp;
    }

    public String cursorLeft(int k) {
        if (pivot >= k) {
            pivot -= k;
            if (pivot < 10) {
                return sb.substring(0, pivot);
            }
            return sb.substring(pivot - 10, pivot);
        }
        pivot = 0;
        return "";
    }

    public String cursorRight(int k) {
        if (pivot + k > sb.length()) {
            pivot = sb.length();
            if (pivot > 10) {
                return sb.substring(pivot - 10);
            }
            return sb.substring(0);
        }
        pivot += k;
        if (pivot > 10) {
            return sb.substring(pivot - 10, pivot);
        }
        return sb.substring(0, pivot);
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addText("leetcode");
        System.out.println(textEditor.deleteText(4));
        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));
    }
}
