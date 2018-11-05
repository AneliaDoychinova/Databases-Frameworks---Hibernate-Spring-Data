package com.user.system.usersystem.validators;


import com.user.system.usersystem.annotations.Picture;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PictureConstraintValidator implements ConstraintValidator<Picture, byte[]> {
   public void initialize(Picture constraint) {
   }

   public boolean isValid(byte[] picture, ConstraintValidatorContext context) {
      if (picture.length > (1024 * 1024)){
         return false;
      }
      return true;
   }
}
