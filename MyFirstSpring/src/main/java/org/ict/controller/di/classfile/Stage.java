package org.ict.controller.di.classfile;

public class Stage {
	
		private Singer singer;
		
		public Stage(Singer singer) {
			this.singer=singer;
		}
		
		public void perform() {
			System.out.print("���뿡�� ");
			singer.sing();
		}
}