SRCDIR = src
BINDIR = bin
DOCDIR = docs
JAVAFILES = src/BinaryNode.java src/BinarySearchTree.java src/AVLTree.java src/PowerAVLApp.java src/PowerBSTApp.java src/dateArray.java src/PowerAVL500.java src/dateArraySort.java

JC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR)

vpath %.java $(SRCDIR)
vpath %.class $(BINDIR)

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $<

all: BinaryNode.class BinarySearchTree.class AVLTree.class PowerAVLApp.class PowerBSTApp.class dateArray.class PowerAVL500.class PowerBST500.class dateArraySort.class doc

.PHONY: doc

doc:
	@javadoc -d doc $(JAVAFILES)

cleandoc:
	@rm -rf| $(DOCDIR)
	@mkdir $(DOCDIR)

clean:
	@rm -f $(BINDIR)/*.class
