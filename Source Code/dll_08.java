public class dll_08 {
    node head, tail;
    int size;

    public dll_08() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(pembeli_08 item) {
        if (isEmpty()) {
            head = new node(null, item, null);
            tail = head;
        } else {
            node newnode = new node(null, item, head);
            head.prev = newnode;
            head = newnode;
        }
        size++;
    }

    public void addLast(pembeli_08 item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            node temp = new node(tail, item, null);
            tail.next = temp;
            tail = temp;
            size++;

        }
    }

    public void add(pembeli_08 item, int index) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size + 1) {
            addLast(item);
        } else {
            node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            node newnode = new node(current.prev, item, current);
            current.prev.next = newnode;
            current.prev = newnode;
            size++;
        }
    }

    public void print() {
        if (!isEmpty()) {
            node tmp = head;
            while (tmp != null) {
                for (int i = 0; i < size; i++) {
                    System.out.println("|No.\t\tNama Customer\t\tNo.hp");
                    System.out.println("|" + i + tmp.data1.namaPembeli + "\t\t" + tmp.data1.noHp);
                    System.out.println("Total Antrian : " + size);
                    tmp = tmp.next;
                }
            }
        } else {
            System.out.println("Linked Lists Kosong");
        }
    }

    public pembeli_08 removeFirst() {
        if (!isEmpty()) {
            pembeli_08 item = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
            size--;
            return item;
        } else {
            return null;
        }
    }

    public pembeli_08 removeLast() {
        if (!isEmpty()) {
            pembeli_08 item = tail.data;
            tail = tail.prev;
            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
            size--;
            return item;
        } else {
            return null;
        }
    }

    public pembeli_08 remove(int index) {
        if (index == 1) {
            return removeFirst();
        } else if (index == size) {
            return removeLast();
        } else {
            node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            pembeli_08 item = current.data;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return item;
        }
    }

    public pembeli_08 get(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("linked List Kosong");
        }
        node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int cari(int id) {
        node tmp = head;
        int index = 0;
        while (tmp.next != null && tmp.data.id != id) {
            tmp = tmp.next;
            index++;
        }
        if (tmp.data.id != id) {
            return -1;
        } else {
            return index;
        }
    }

    public void printDesc() {
        if (!isEmpty()) {
            pembeli_08[] PembeliOrdered = new pembeli_08[size];
            node current = head;
            int counter = 0;
            // Store data from list to array
            while (true) {
                if (counter == size)
                    break;
                PembeliOrdered[counter] = current.data;
                counter++;
                current = current.next;
            }
            // Sort array
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (PembeliOrdered[i].rating < PembeliOrdered[j].rating) {
                        pembeli_08 temp = PembeliOrdered[i];
                        PembeliOrdered[i] = PembeliOrdered[j];
                        PembeliOrdered[j] = temp;
                    }
                }
            }
            // Print array
            System.out.println("Cetak Data pembeli_08 Berdasarkan Rating Desc");
            for (int i = 0; i < size; i++) {
                System.out.println(PembeliOrdered[i]);
                System.out.println("");
            }
        } else {
            System.out.println("List masih kosong");
        }

    }
}
