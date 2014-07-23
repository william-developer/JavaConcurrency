package com.chapter8;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import com.chapter8.SequentialPuzzleSolver.Node;

public class PuzzleSolver<P, M> extends ConcurrentPuzzleSolver<P, M> {
	private final AtomicInteger taskCount = new AtomicInteger();
	
	public PuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec,
			ConcurrentMap<P, Boolean> seen) {
		super(puzzle, exec, seen);
		// TODO Auto-generated constructor stub
	}
	protected Runnable newTask(P p,M m,Node<P,M> n){
		return new CountingSolverTask(p,m,n);
	}
	class CountingSolverTask extends SolverTask{
		CountingSolverTask(P p,M m,Node<P,M> n){
			super(p,m,n);
			taskCount.incrementAndGet();
		}
		public void run(){
			try{
				super.run();
			}finally{
				if(taskCount.decrementAndGet()==0)
					solution.setValue(null);
			}
		}
	}
	
}
