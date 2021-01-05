package leetcode_jan_challenge

fun main(args: Array<String>) {
    val list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next?.next = ListNode(4)

    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next?.next = ListNode(4)


    MergeTwoSortedLinkedLists()
        .mergeTwoLists(list1, list2)
        .apply {
            var tempList = this

            while (tempList != null) {
                print("${tempList.value} ")
                tempList = tempList.next
            }
        }
}

class MergeTwoSortedLinkedLists {
    //TODO: Refactor code by moving the reusable code to function
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var resultList: ListNode? = null
        var endNode: ListNode? = resultList

        var list1 = l1
        var list2 = l2

        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                swapNodes(list1, resultList, endNode).apply {
                    list1 = this.first
                    resultList = this.second
                    endNode = this.third
                }
            } else {
                swapNodes(list2, resultList, endNode).apply {
                    list2 = this.first
                    resultList = this.second
                    endNode = this.third
                }
            }
        }

        while (list1 != null) {
            swapNodes(list1!!, resultList, endNode).apply {
                list1 = this.first
                resultList = this.second
                endNode = this.third
            }
        }

        while (list2 != null) {
            swapNodes(list2!!, resultList, endNode).apply {
                list2 = this.first
                resultList = this.second
                endNode = this.third
            }
        }

        return resultList
    }

    /**
     * This function basically checks
     * If resultNode is null -> Initiate new list and keep track of endNode for future ref.
     * If resultNode is not null -> Add the new node to the end of list node.
     * And move to the next node.
     *
     * @param listNode - current node we are looking at
     * @param result - the result list
     * @param endNode - the end node to keep track of the end of the result list
     */
    private fun swapNodes(
        listNode: ListNode,
        result: ListNode?,
        endNode: ListNode?
    ): Triple<ListNode?, ListNode?, ListNode?> {

        var tempResult: ListNode? = result
        var tempEndNode: ListNode? = endNode

        if (result == null) {
            tempResult = ListNode(listNode.value)
            tempEndNode = tempResult
        } else {
            tempEndNode?.next = ListNode(listNode.value)
            tempEndNode = tempEndNode?.next
        }

        return Triple(listNode.next, tempResult, tempEndNode)
    }
}

data class ListNode(var value: Int, var next: ListNode? = null)
