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
                if (resultList == null) {
                    resultList = ListNode(list1.value)
                    endNode = resultList
                } else {
                    endNode?.next = ListNode(list1.value)
                    endNode = endNode?.next
                }
                list1 = list1.next
            } else {
                if (resultList == null) {
                    resultList = ListNode(list2.value)
                    endNode = resultList
                } else {
                    endNode?.next = ListNode(list2.value)
                    endNode = endNode?.next
                }
                list2 = list2.next
            }
        }

        while (list1 != null) {
            if (resultList == null) {
                resultList = ListNode(list1.value)
                endNode = resultList
            } else {
                endNode?.next = ListNode(list1.value)
                endNode = endNode?.next
            }
            list1 = list1.next
        }

        while (list2 != null) {
            if (resultList == null) {
                resultList = ListNode(list2.value)
                endNode = resultList
            } else {
                endNode?.next = ListNode(list2.value)
                endNode = endNode?.next
            }
            list2 = list2.next
        }

        return resultList
    }
}

data class ListNode(var value: Int, var next: ListNode? = null)
