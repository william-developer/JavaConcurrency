package com.chapter8;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public interface Puzzle<P, M> {
	P initialPosition();
	boolean isGoal(P position);
	Set<M> legalMoves(P position);
	P move(P position,M move);
}
