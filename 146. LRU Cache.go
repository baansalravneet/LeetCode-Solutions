type LRUCache struct {
	capacity int
	pointers map[int]*Node
	head, tail *Node
}

type Node struct {
	key, val int
	next, prev *Node
}


func Constructor(capacity int) LRUCache {
	return LRUCache {
		capacity,
		make(map[int]*Node),
		nil,
		nil,
	}
}


func (this *LRUCache) Get(key int) int {
	if _, ok := this.pointers[key]; !ok {
		return -1
	}
	node := this.pointers[key]
	this.makeHead(node)
	return (*node).val
}


func (this *LRUCache) Put(key int, value int)  {
	if _, ok := this.pointers[key]; !ok {
		this.pointers[key] = &Node{key, value, nil, nil}
	}
	node := this.pointers[key]
	node.val = value
	if this.tail == nil {
		this.tail = node
	}
	this.makeHead(node)
	if len(this.pointers) > this.capacity {
		delete(this.pointers, this.removeTail().key)
	}
}

func (this *LRUCache) makeHead(node *Node) {
	if this.head == nil || node == this.head {
		this.head = node
		return
	}
	this.freeNode(node)
	node.next = this.head
	this.head.prev = node
	this.head = node
}

func (this *LRUCache) freeNode(node *Node) {
	if this.tail == node {
		this.tail = this.tail.prev
	}
	if node.prev != nil {
		node.prev.next = node.next
	}
	if node.next != nil {
		node.next.prev = node.prev
	}
	node.next = nil
	node.prev = nil
}

func (this *LRUCache) removeTail () *Node {
	tailNode := this.tail
	this.tail = tailNode.prev
	this.tail.next = nil
	return tailNode
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */