func findTheWinner(n int, k int) int {
    head := getLinkedList(n)
    pointer := head
    for pointer.next != pointer {
        count := k-1
        for count > 0 {
            pointer = pointer.next
            count--
        }
        pointer.prev.next = pointer.next
        pointer.next.prev = pointer.prev
        pointer = pointer.next
    }
    return pointer.index
}

func getLinkedList(n int) *Node {
    head := newNode(1)
    pointer := head
    for i := 2; i <= n; i++ {
        friend := newNode(i)
        pointer.next = friend
        friend.prev = pointer
        pointer = pointer.next
    }
    head.prev = pointer
    pointer.next = head
    return head
}

type Node struct {
    next, prev *Node
    index int
}

func newNode(index int) *Node {
    return &Node{index: index}
}
