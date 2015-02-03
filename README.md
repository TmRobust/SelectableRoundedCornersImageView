<h1>SelectableRoundedCornersImageView</h1>
Android ImageView that supports different radii on each corner.Also it can supports oval by adding more attrs.

<h3>Attributes:</h3>
leftTopCornerRadius: the radius of the left top corner

    <declare-styleable name="SelectableRoundedCornersImageView">
        <attr name="leftTopCornerRadius" format="dimension" />
        <attr name="rightTopCornerRadius" format="dimension" />
        <attr name="leftBottomCornerRadius" format="dimension" />
        <attr name="rightBottomCornerRadius" format="dimension" />
    </declare-styleable>

<h3>XML:</h3>
    <com.example.selectableroundedcornersimageview.SelectableRoundedCornersImageView
        android:id="@+id/image1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:scaleType="centerCrop"
        android:src="@drawable/koala"
        app:leftBottomCornerRadius="6dp"
        app:leftTopCornerRadius="6dp"
        app:rightBottomCornerRadius="6dp"
        app:rightTopCornerRadius="6dp" />
    
circle imageview

    <com.example.selectableroundedcornersimageview.SelectableRoundedCornersImageView
        android:id="@+id/image5"
        android:layout_width="300dp"
        android:layout_height="300dp"
        android:layout_marginTop="10dp"
        android:scaleType="centerCrop"
        android:src="@drawable/koala"
        app:leftBottomCornerRadius="150dp"
        app:leftTopCornerRadius="150dp"
        app:rightBottomCornerRadius="150dp"
        app:rightTopCornerRadius="150dp" />

