// User Register validation
var $userRegister = $("#userRegister");

$userRegister.validate({
    rules: {
        name: {
            required: true,
            lettersonly: true
        },
        email: {
            required: true,
            space: true,
            email: true
        },
        mobileNumber: {
            required: true,
            numericOnly: true,
            minlength: 10,
            maxlength: 12
        },
        password: {
            required: true,
            space: true
        },
        confirmpassword: {
            required: true,
            space: true,
            equalTo: '#password'  // Use consistent ID
        },
        address: {
            required: true,
            all: true
        },
        city: {
            required: true,
            space: true
        },
        state: {
            required: true
        },
        pincode: {
            required: true,
            numericOnly: true,
            minlength: 6, // Ensure proper pin code length
            maxlength: 6
        },
        img: {
            required: true,
        }
    },
    messages: {
        name: {
            required: 'Name is required',
            lettersonly: 'Invalid name format'
        },
        email: {
            required: 'Email is required',
            space: 'Spaces are not allowed',
            email: 'Invalid email format'
        },
        mobileNumber: {
            required: 'Mobile number is required',
            numericOnly: 'Mobile number must be numeric',
            minlength: 'Mobile number must be at least 10 digits',
            maxlength: 'Mobile number must not exceed 12 digits'
        },
        password: {
            required: 'Password is required',
            space: 'Spaces are not allowed'
        },
        confirmpassword: {
            required: 'Confirm password is required',
            space: 'Spaces are not allowed',
            equalTo: 'Passwords do not match'
        },
        address: {
            required: 'Address is required',
            all: 'Invalid address format'
        },
        city: {
            required: 'City is required',
            space: 'Spaces are not allowed'
        },
        state: {
            required: 'State is required'
        },
        pincode: {
            required: 'Pincode is required',
            numericOnly: 'Pincode must be numeric',
            minlength: 'Pincode must be 6 digits',
            maxlength: 'Pincode must be 6 digits'
        },
        img: {
            required: 'Image is required',
        }
    }
});
