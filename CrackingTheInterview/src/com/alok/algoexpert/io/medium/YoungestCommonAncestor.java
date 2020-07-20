/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */

public class YoungestCommonAncestor {

	public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
			AncestralTree descendantTwo) {
		int depthOne = getDepth(topAncestor, descendantOne);
		int depthTwo = getDepth(topAncestor, descendantTwo);

		if (depthOne > depthTwo) {
			descendantOne = doSameLevel(descendantOne, depthOne - depthTwo);
		} else {
			descendantTwo = doSameLevel(descendantTwo, depthTwo - depthOne);
		}
		while (descendantOne != descendantTwo) {
			descendantOne = descendantOne.ancestor;
			descendantTwo = descendantTwo.ancestor;
		}

		return descendantOne;
	}

	private static AncestralTree doSameLevel(AncestralTree desc, int depth) {
		while (depth > 0) {
			desc = desc.ancestor;
			depth--;
		}
		return desc;
	}

	private static int getDepth(AncestralTree ancestor, AncestralTree desc) {
		int count = 0;
		while (desc != null) {
			count++;
			desc = desc.ancestor;
		}
		return count;
	}

	static class AncestralTree {
		public char name;
		public AncestralTree ancestor;

		AncestralTree(char name) {
			this.name = name;
			this.ancestor = null;
		}

		// This method is for testing only.
		void addAsAncestor(AncestralTree[] descendants) {
			for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
			}
		}
	}
}
