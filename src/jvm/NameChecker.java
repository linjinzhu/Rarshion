package jvm;


import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementScanner6;

import static javax.tools.Diagnostic.Kind.WARNING;


/**
 * Created by rarshion on 17/1/6.
 */
public class NameChecker {

    private final Messager messager;

    NameChecker(ProcessingEnvironment proccessingEnv) {
        this.messager = proccessingEnv.getMessager();
    }

    public void checkName(Element element) {

    }

    private class NameChekScanner extends ElementScanner6<Void, Void> {

        @Override
        public Void visitType(TypeElement e, Void p) {
            scan(e.getTypeParameters(), p);
            checkCameClass(e, true);
            super.visitType(e, p);
            return null;
        }

        private void checkCameClass(Element e, boolean initialCaps) {
            String name = e.getSimpleName().toString();
            boolean previousUpper = false;
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);
            if (Character.isUpperCase(firstCodePoint)) {
                previousUpper = true;
                if (!initialCaps) {
                    messager.printMessage(WARNING, "名称" + name + "应该以小写字母开头", e);
                    return;
                }
            }

        }

    }



}
