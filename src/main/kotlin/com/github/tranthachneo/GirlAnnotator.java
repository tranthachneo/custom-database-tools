package com.github.tranthachneo;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

class GirlAnnotator implements Annotator {

    // override fun annotate
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if( element.getText().equals("return") ) {
            @NotNull TextRange range = new TextRange(element.getTextRange().getStartOffset(), element.getTextRange().getEndOffset());
            @NotNull TextAttributesKey attributes = TextAttributesKey.createTextAttributesKey("PHP.RETURN");

            holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(range)
                    .textAttributes(attributes)
                    .create();
        }
    }
}
